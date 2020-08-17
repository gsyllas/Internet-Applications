import React, { Component } from "react";

class KobeVideo extends Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div
        className="video"
        style={{
          marginLeft: 50,
          position: "relative",
          paddingBottom: "56.25%" /* 16:9 */,
          paddingTop: 25,
          height: 0,
        }}
      >
        <iframe
          style={{
            position: "absolute",
            top: 0,
            left: 0,
            width: "50%",
            height: "50%",
          }}
          src={`https://www.youtube.com/embed/7mFGeA5YDzw`}
          frameBorder="0"
        />
      </div>
    );
  }
}

export default KobeVideo;
