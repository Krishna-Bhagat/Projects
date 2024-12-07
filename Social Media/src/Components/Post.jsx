import { useContext } from "react";
import image from "../assets/20231015_015533.jpg";
import styles from "./Post.module.css";
import { MdDeleteForever } from "react-icons/md";
import { postContext } from "../Store/post.store";

function Post({ post }) {
  const { deletePost } = useContext(postContext);
  return (
    <div className={`card ${styles.postcontainer}`}>
      <span
        className="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"
        style={{ fontSize: "larger" }}
        onClick={() => deletePost(post.id)}
      >
        <MdDeleteForever />
        <span className="visually-hidden">delete post</span>
      </span>
      <div className={styles.title}>{post.name}</div>
      <div className="card-body">
        <p className="card-text">{post.discription}</p>
      </div>
      <div className={styles.tags}>
        {post.hashtags.map((hash) => (
          <h4 style={{ display: "inline" }} key={hash}>
            <span className="badge text-bg-secondary">{hash}</span>
          </h4>
        ))}
      </div>

      <div className={styles.imagecontainer}>
        <img
          src={image}
          className="card-img-top"
          alt="..."
          style={{ width: "20rem" }}
        />
      </div>
    </div>
  );
}
export default Post;
