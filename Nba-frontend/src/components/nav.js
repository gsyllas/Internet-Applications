import React, { Component } from "react";
import "./Nav.css";
import Image from "react-bootstrap/Image";

class Navbar extends Component {
  render() {
    return (
      <div>
        <nav className="navbar" style={{ maxHeight: 100 }}>
          <ul className="navbar-nav">
            <li className="nav-item active">
              <span className="logo">
                <Image
                  src="data:image/jpeg;base64,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"
                  height="50"
                  width="50"
                  roundedCircle
                />
              </span>
            </li>
          </ul>
          <ul className="navbar-nav">
            <li className="nav-item active">
              <a
                className="nav-link"
                href="https://www.nba.com/"
                style={{
                  color: "white",
                  fontStyle: "italic",
                  fontWeight: "bold",
                  fontSize: 25,
                }}
              >
                More @ nba.com
              </a>
            </li>
          </ul>
          <ul className="navbar-nav">
            <li
              className="nav-item active"
              style={{
                fontSize: 18,
              }}
            >
              usernameHere
            </li>
          </ul>
        </nav>
      </div>
    );
  }
}

export default Navbar;
