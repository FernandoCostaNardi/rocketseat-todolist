import { useState } from 'react'

import { Header } from './components/header/Header'
import { TaskSection, TaskProps } from './components/tasksection/TaskSection'

import './Global.css'

function App() {
  const [tasks, setTasks] = useState<TaskProps[]>([])

  const handleNewTask = (newTask: string) => {
    if (!newTask) {
      return
    }

    const taskProps: TaskProps = {
      id: tasks.length + 1,
      content: newTask,
      status: false,
    }

    setTasks((state) => [...state, taskProps])
  }

  const HandleRemoveTask = (id: number) => {
    const newTasks = tasks.filter((task) => task.id !== id)
    setTasks(newTasks)
  }

  const handleTaskToggle = (id: number, status: boolean) => {
    const newTasks = tasks.map((task) => {
      if (task.id === id) {
        task.status = status
      }
      return task
    })

    setTasks(newTasks)
  }

  return (
    <div>
      <Header newTask={handleNewTask} />
      <main>
        <TaskSection
          tasks={tasks}
          removeTasK={HandleRemoveTask}
          handleToggle={handleTaskToggle}
        />
      </main>
    </div>
  )
}

export default App
