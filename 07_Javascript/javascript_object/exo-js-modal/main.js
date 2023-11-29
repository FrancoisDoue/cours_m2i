import Task from "./task.js";

document.addEventListener('DOMContentLoaded', () => {
    const addTaskBtn = document.getElementById('add-task-btn');
    const formModal = document.querySelector('div.modal');
    const mainForm = document.getElementById('form-add-task')
    const inputList = mainForm.querySelectorAll('input, textarea');
    const tableToDo = document.getElementById('table-todo');

    let taskList = {};

    const btnMaker = (key, refObject) => {
        const actionSelection = {
            Supprimer : () => {
                document.querySelector(`[data-todo${(refObject.isDone)? '-done': '-row'}="${refObject.id}"]`).remove()  
            },
            Editer : () => {
                document.querySelector('[name="title"]').value = refObject.title;
                document.querySelector('[name="detail"]').value = refObject.detail;
                document.querySelector('form#form-add-task button').textContent = 'modifier'
                mainForm.setAttribute('data-todo-edit',1);
                console.log(mainForm.dataset.todoEdit)
                formModal.style.display = 'flex';
            },
            // Fait : () => {
            //     refObject.isDone = true;
            //     console.log(refObject, refObject.isDone)
            // },
        }
        const btn = document.createElement('button');
        btn.textContent = key;
        btn.addEventListener('click', actionSelection[key])
        return(btn)
    }

    addTaskBtn.addEventListener('click', () => formModal.style.display = 'flex');
    formModal.addEventListener('click', event => {
        if(event.target === formModal) 
            formModal.style.display = 'none';
    });

    mainForm.addEventListener('submit', e => {
        e.preventDefault();
        let construct = [], error = false;

        inputList.forEach(input => {
            if (input.name === 'title' && input.value === "") error = true;
            construct.push(input.value)
            input.value = '';
        });
        if(!error){
            const newTask = new Task(...construct);
            const row = tableToDo.insertRow();
            newTask.getArrayFromProperties().map((el) => {
                row.insertCell().textContent = (el.length > 50) ? el.substring(0,50)+' ...' : el;
            });
            row.insertCell().appendChild(btnMaker("Supprimer", newTask))
            row.insertCell().appendChild(btnMaker("Editer", newTask));
            // row.insertCell().appendChild(btnMaker("Fait", newTask));
            row.setAttribute("data-todo-row", newTask.id);
            taskList[newTask.id] = newTask;
            console.log(taskList)
        }
        formModal.style.display = 'none'; 
    });
});
