function Sidebar({ sidebar, setsidebar }) {
  return (
    <div
      className={`d-flex flex-column flex-shrink-0 p-3 bg-body-tertiary`}
      style={{ width: "220px", height: "100vh" }}
    >
      <a
        href="/"
        className="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none"
      >
        <svg className="bi pe-none me-2" width="40" height="32">
          <use xlinkHref="#bootstrap"></use>
        </svg>
        <span className="fs-4">MiniBook</span>
      </a>
      <hr />
      <ul className="nav nav-pills flex-column mb-auto">
        <li className="nav-item" onClick={() => setsidebar("Home")}>
          <a
            href="#"
            className={`nav-link link-body-emphasis ${
              sidebar === "Home" ? "active" : ""
            }`}
            aria-current="page"
          >
            <svg className="bi pe-none me-2" width="16" height="16">
              <use xlinkHref="#home"></use>
            </svg>
            Home
          </a>
        </li>
        <li className="nav-item" onClick={() => setsidebar("Create Post")}>
          <a
            href="#"
            className={`nav-link link-body-emphasis  ${
              sidebar === "Create Post" ? "active" : ""
            }`}
          >
            <svg className="bi pe-none me-2" width="16" height="16">
              <use xlinkHref="#speedometer2"></use>
            </svg>
            Create Post
          </a>
        </li>
      </ul>
      <hr />
      <div>
        <a
          href="#"
          className="d-flex align-items-center link-body-emphasis text-decoration-none"
          data-bs-toggle="dropdown"
          aria-expanded="false"
        >
          <img
            src="https://github.com/mdo.png"
            alt=""
            width="32"
            height="32"
            className="rounded-circle me-2"
          />
          <strong>Profile name</strong>
        </a>
      </div>
    </div>
  );
}

export default Sidebar;
