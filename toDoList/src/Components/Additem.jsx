function Additem(props) {
  const { task, date, ondelete } = props;

  const ondeletehandle = () => {
    ondelete(task);
  };
  return (
    <div class="container text-center">
      <div class="row">
        <div class="col-5">{task}</div>
        <div class="col-5">{date}</div>
        <div class="col-2">
          <button
            type="button"
            class="btn btn-outline-danger"
            onClick={() => ondeletehandle()}
          >
            Delete
          </button>
        </div>
      </div>
    </div>
  );
}
export default Additem;
