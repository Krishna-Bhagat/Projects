import { useState } from "react";

function Addtodo({ onButtonClick }) {
  const [todotask, settodotask] = useState("");
  const [tododate, settododate] = useState("");

  const onActivetask = (event) => {
    let value = event.target.value;
    settodotask(value);
  };

  const onActivedate = (event) => {
    let value = event.target.value;
    settododate(value);
  };

  const onAdd = () => {
    onButtonClick(todotask, tododate);
    settodotask("");
    settododate("");
  };

  return (
    <div class="container text-center">
      <div class="row">
        <div class="col-5">
          <input
            type="text"
            placeholder="Enter Todo here"
            value={todotask}
            onChange={onActivetask}
          ></input>
        </div>
        <div class="col-5">
          <input type="date" value={tododate} onChange={onActivedate}></input>
        </div>
        <div class="col-2">
          <button
            type="button"
            class="btn btn-outline-success"
            onClick={() => onAdd()}
          >
            Add
          </button>
        </div>
      </div>
    </div>
  );
}

export default Addtodo;
