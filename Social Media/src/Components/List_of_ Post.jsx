import { useContext } from "react";
import Post from "./Post";
import { postContext } from "../Store/post.store";

function List_of_Post() {
  const { newpostData } = useContext(postContext);
  return (
    <>
      {newpostData.map((post) => (
        <Post key={post.id} post={post} />
      ))}
    </>
  );
}

export default List_of_Post;
