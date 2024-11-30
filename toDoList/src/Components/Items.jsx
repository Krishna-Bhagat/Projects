import Additem from "./Additem";

function Items({ items, ondelete }) {
  return (
    <>
      {items.map((item) => (
        <Additem
          task={item["task"]}
          date={item["date"]}
          ondelete={ondelete}
        ></Additem>
      ))}
    </>
  );
}

export default Items;
