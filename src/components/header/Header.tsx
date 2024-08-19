import { useState } from 'react'

import { InputBar } from './inputbar/InputBar'
import { Logo } from './logo/Logo'
import { CreateButton } from './createbutton/CreateButton'

import styles from './Header.module.css'

export function Header({ newTask }: { newTask: (newTask: string) => void }) {
  const createNewTask = (data: string) => {
    newTask(data)
    setInputBarValue('')
  }

  const [inputBarValue, setInputBarValue] = useState('')

  return (
    <div>
      <Logo />
      <div className={styles.header}>
        <InputBar
          onChange={(e) => setInputBarValue(e.target.value)}
          value={inputBarValue}
        />
        <CreateButton onClick={() => createNewTask(inputBarValue)} />
      </div>
    </div>
  )
}
