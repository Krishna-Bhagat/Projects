import Addtodo from "./Components/Addtodo";
import Appname from "./Components/Appname";
import styles from "./App.module.css";
import Error from "./Components/Error";
import { useState } from "react";
import Items from "./Components/Items";
function App() {
  let setOfTasks = [
    { task: "Buy Milk", date: "4/10/2023" },
    { task: "Go To College", date: "4/11/2023" },
    { task: "Go To Home", date: "8/11/2023" },
  ];
  // let setOfTasks = [];

  const [todoitems, settodoitems] = useState(setOfTasks);

  const onButtonClick = (todotask, tododate) => {
    let newSetOfTasks = [...todoitems, { task: todotask, date: tododate }];
    settodoitems(newSetOfTasks);
  };

  const onDelete = (tasktobedelete) => {
    const newsetoftodo = todoitems.filter(
      (item) => item.task !== tasktobedelete
    );
    settodoitems(newsetoftodo);
  };

  return (
    <div className={styles.main}>
      <center className={styles.todocontainer}>
        <Appname></Appname>
        <Addtodo onButtonClick={onButtonClick}></Addtodo>
        <Error todoitems={todoitems}></Error>
        <Items items={todoitems} ondelete={onDelete}></Items>
      </center>
    </div>
  );
}

export default App;
