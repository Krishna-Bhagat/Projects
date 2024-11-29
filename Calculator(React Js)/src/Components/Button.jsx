import styles from "./Button.module.css";

function Button({ onClick }) {
  const buttons = [
    "C",
    1,
    2,
    "+",
    3,
    4,
    "-",
    5,
    6,
    "*",
    7,
    8,
    "/",
    "=",
    9,
    0,
    ".",
  ];
  return (
    <>
      {buttons.map((but, index) => (
        <button key={index} className={styles.design} onClick={onClick}>
          {but}
        </button>
      ))}
    </>
  );
}

export default Button;
