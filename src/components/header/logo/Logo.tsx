import styles from './Logo.module.css'

export function Logo() {
  return (
    <header className={styles.header}>
      <img src="/rocket.svg" alt="Logo" />
      <p>
        <span>to</span>
        <span>do</span>
      </p>
    </header>
  )
}
