import Button from "./Components/Button";
import styles from "./App.module.css";
import Display from "./Components/display";
import { useState } from "react";

function App() {
  const [textToDisplay, setTextToDisplay] = useState("");

  const onClick = (event) => {
    // console.log("Button clicked");
    // console.log(event);
    // console.log(event.target.innerText);
    let num = event.target.innerText;
    if (num === "C") {
      setTextToDisplay("");
    } else if (num === "=") {
      const result = eval(textToDisplay);
      setTextToDisplay(result);
    } else {
      let newtextToDisplay = textToDisplay + num;
      setTextToDisplay(newtextToDisplay);
    }
  };

  return (
    <>
      <div className={styles.mainContainer}>
        <Display text={textToDisplay}></Display>
        <div className={styles.buttondesign}>
          <Button onClick={onClick}></Button>
        </div>
      </div>
    </>
  );
}

export default App;
