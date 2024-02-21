import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import FormTodo from './component/FormTodo'
import TaskCard from './component/TaskCard'


function App() {
  const [todoList, setTodoList] = useState([])

  const handleNewTodo = (values) => {
    setTodoList([
      ...todoList, 
      <TaskCard 
        key={values.id} 
        values={values} 
        emitDelete={deleteTask}
      />
    ])
  }
  const deleteTask = (id) => {
    setTodoList((prevList) => [...prevList.filter((e) => e.props.values.id !== id )])
  }

  return (
    <>
    <header>
      <h1><span><img src={reactLogo} alt="react" /></span>TP Todo</h1>
    </header>
    <main>
      <FormTodo emitSubmit={handleNewTodo}/>
      <div className='todo-list'>
        <div>
          <h3>To do . . .</h3>
        </div>
        {todoList}
      </div>
    </main>

    </>
  )
}

export default App
