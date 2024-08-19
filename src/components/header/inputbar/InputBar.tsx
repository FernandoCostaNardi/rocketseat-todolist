import styles from './InputBar.module.css'

export function InputBar({
  ...rest
}: React.DetailedHTMLProps<
  React.InputHTMLAttributes<HTMLInputElement>,
  HTMLInputElement
>) {
  return (
    <div className={styles.inputBar}>
      <input type="text" placeholder="Adicione uma nova tarefa" {...rest} />
    </div>
  )
}
