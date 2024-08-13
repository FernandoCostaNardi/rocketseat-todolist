import { Header } from './components/Header'
import { NewTask } from './components/newTask'
import { ListTasks } from './components/ListTasks'

import './Global.css'

function App() {
  return (
    <div>
      <Header />

      <main>
        <NewTask />
        <ListTasks />
      </main>
    </div>
  )
}

export default App
