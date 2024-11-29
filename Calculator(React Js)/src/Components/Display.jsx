import styles from "./Display.module.css";

function Display({ text }) {
  return (
    <input type="text" className={styles.display} value={text} readOnly></input>
  );
}

export default Display;
