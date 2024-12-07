import { useState } from "react";
import "./App.css";
import Footer from "./Components/Footer";
import Header from "./Components/Header";
import Sidebar from "./Components/Sidebar";
import CreatePost from "./Components/CreatePost";
import List_of_Post from "./Components/List_of_ Post";
import Postdataprovider from "./Store/post.store";

function App() {
  const [sidebarstatus, setsidebarstatus] = useState("Home");
  return (
    <Postdataprovider>
      <div className="main-container">
        <Sidebar
          sidebar={sidebarstatus}
          setsidebar={setsidebarstatus}
        ></Sidebar>
        <div className="right-flex">
          <Header></Header>
          {sidebarstatus === "Home" ? (
            <List_of_Post></List_of_Post>
          ) : (
            <CreatePost></CreatePost>
          )}
          <Footer></Footer>
        </div>
      </div>
    </Postdataprovider>
  );
}

export default App;
