import styles from "./Error.module.css";

function Error({ todoitems }) {
  return (
    <>
      {todoitems.length === 0 && (
        <p className={styles.message}>
          No Work for Today
          <br /> Enjoy Your Day!
        </p>
      )}
    </>
  );
}

export default Error;
