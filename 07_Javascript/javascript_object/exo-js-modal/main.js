import Task from "./task.js";

document.addEventListener('DOMContentLoaded', () => {
    const addTaskBtn = document.getElementById('add-task-btn');
    const formModal = document.querySelector('div.modal');
    const mainForm = document.getElementById('form-add-task')
    const inputList = mainForm.querySelectorAll('input, textarea');
    const tableToDo = document.getElementById('table-todo');

    let taskList = {};

    const btnMaker = (key, refObject) => {
        const btn = document.createElement('button');
        btn.textContent = key;
        btn.addEventListener('click', () => {
            switch (key) {
                case "Delete", "Supprimer": 
                    document.querySelector(`[data-todo-row="${refObject.id}"]`).remove()
                    delete taskList[refObject.id];
                    break;
                case "edit", "Editer":
                    document.querySelector('[name="title"]').value = refObject.title;
                    document.querySelector('[name="detail"]').value = refObject.detail;
                    document.querySelector('form#form-add-task button').textContent = 'modifier'
                    // mainForm.setAttribute('data-todo-edit',refObject.id);
                    mainForm.dataset.todoEdit = refObject.id
                    console.log(mainForm.dataset.todoEdit);
                    formModal.style.display = 'flex';
                    break;
                default: return console.log('useless btn');
            }
        })
        return(btn)
    }

    addTaskBtn.addEventListener('click', () => formModal.style.display = 'flex');
    formModal.addEventListener('click', event => {
        if(event.target === formModal) 
            formModal.style.display = 'none';
    });

    mainForm.addEventListener('submit', e => {
        e.preventDefault();
        let construct = [], error = false, currentTask, row;
        inputList.forEach(input => {
            if (input.name === 'title' && input.value === "") error = true;
            construct.push(input.value)
            input.value = '';
        });
        if(!error){
            if (mainForm.dataset.todoEdit){
                currentTask = taskList[mainForm.dataset.todoEdit];
                row = document.querySelector(`[data-todo-row="${currentTask.id}"]`);
                row.querySelectorAll('*').forEach(element => element.remove()); // Blyat!
                currentTask.editContent(...construct);
                mainForm.removeAttribute('data-todo-edit')
                document.querySelector('form#form-add-task button').textContent = 'Ajouter';
            }else{
                currentTask = new Task(...construct);
                row = tableToDo.insertRow();
                // row.setAttribute("data-todo-row", currentTask.id);
                row.dataset.todoRow = currentTask.id;
                taskList[currentTask.id] = currentTask;
            }
            currentTask.getArrayFromProperties().map((el) => {
                row.insertCell().textContent = (el.length > 50) ? el.substring(0,50)+' ...' : el;
            });
            row.insertCell().appendChild(btnMaker("edit", currentTask));
            row.insertCell().appendChild(btnMaker("Supprimer", currentTask));
            console.log(taskList)
        }
        formModal.style.display = 'none'; 
    });
});
            // Fait : () => {
            //     refObject.isDone = true;
            //     console.log(refObject, refObject.isDone)
            // },
