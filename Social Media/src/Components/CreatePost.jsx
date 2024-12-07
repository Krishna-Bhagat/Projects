import { useContext, useRef } from "react";
import { postContext } from "../Store/post.store";

function CreatePost() {
  const { createPost } = useContext(postContext);
  const nameElement = useRef();
  const descriptionElement = useRef();
  const hashtagsElement = useRef();

  const formhandling = (event) => {
    event.preventDefault();
    const name = nameElement.current.value;
    const description = descriptionElement.current.value;
    const hashtags = hashtagsElement.current.value.split(" ");
    nameElement.current.value = "";
    descriptionElement.current.value = "";
    hashtagsElement.current.value = "";
    createPost(name, description, hashtags);
  };
  return (
    <form className="formcontainer" onSubmit={formhandling}>
      <div class="mb-3">
        <label for="name" class="form-label">
          Your name:
        </label>
        <input
          type="text"
          class="form-control"
          id="name"
          ref={nameElement}
          placeholder="Krishna Bhagat"
        />
      </div>
      <div class="mb-3">
        <label for="description" class="form-label">
          Description for the post:
        </label>
        <textarea
          class="form-control"
          id="description"
          rows="3"
          ref={descriptionElement}
          placeholder="Write something about your post...."
        ></textarea>
      </div>
      <div class="mb-3">
        <label for="hashtags" class="form-label">
          Hashtags:
        </label>
        <input
          type="text"
          class="form-control"
          id="hashtags"
          ref={hashtagsElement}
          placeholder="happy sad excitement visit pass"
        />
      </div>
      <div class="mb-3">
        <input class="btn btn-primary" type="submit" value="Post" />
      </div>
    </form>
  );
}

export default CreatePost;
