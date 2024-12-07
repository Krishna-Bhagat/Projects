import { createContext, useReducer } from "react";

export const postContext = createContext({
  newpostData: [],
  createPost: () => {},
  deletePost: () => {},
});

function postreducer(currentpostdata, actionobject) {
  let newpostData = currentpostdata;
  if (actionobject.type === "DELETE_POST") {
    newpostData = currentpostdata.filter(
      (post) => post.id !== actionobject.payload.postId
    );
  } else {
    newpostData = [...currentpostdata, actionobject.payload];
  }
  return newpostData;
}

function Postdataprovider({ children }) {
  const [newpostData, postDispatcher] = useReducer(postreducer, postData);

  const createPost = (name, description, hashtags) => {
    postDispatcher({
      type: "CREATE_POST",
      payload: {
        id: new Date().getTime(),
        name: name,
        discription: description,
        hashtags: hashtags,
      },
    });
  };
  const deletePost = (postId) => {
    postDispatcher({
      type: "DELETE_POST",
      payload: {
        postId,
      },
    });
  };

  return (
    <postContext.Provider value={{ newpostData, createPost, deletePost }}>
      {children}
    </postContext.Provider>
  );
}

let postData = [
  {
    id: 1,
    name: "Krishna Bhagat",
    discription:
      "Going to tirupati, very excited for the journey and will share you every moment.",
    hashtags: ["excitement", "visit", "temple", "happy"],
  },
  {
    id: 2,
    name: "Ram Kumar Bhagat",
    discription:
      "passed my 12th board exam and very happy for the upcoming journey. i want to study medical for my next of my life.",
    hashtags: ["passed", "medical", "life", "happy"],
  },
  {
    id: 3,
    name: "Shiv kumar yadav",
    discription:
      "Visiting home after a long time and i am very excited to meet my mom there who is waiting there for me with food",
    hashtags: ["excitement", "visit", "home", "mom"],
  },
];

export default Postdataprovider;
