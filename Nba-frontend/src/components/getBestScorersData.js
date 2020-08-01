import React, { Component } from "react";
import { Button, Container } from "react-bootstrap";
import BestScorersData from "./BestScorersData";
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";

class GetBestScorersData extends Component {
  state = {
    //playerName: "James Harden",
    hasData: false,
    playerData: null,
  };

  constructor(props) {
    super(props);
    this.year = React.createRef();
    this.getPlayer = this.getPlayer.bind(this);
  }

  getPlayer() {
    console.log(this.year.current.value);
    var year = this.year.current.value;
    var url;
    url = "https://localhost:8765/nba/api/BestScorers/" + year;
    console.log("executing...", url);
    fetch(url, {
      method: "GET",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded",
      },
    })
      .then((response) => {
        if (response.ok) {
          return response;
        } else throw new Error([response.status, response.statusText]);
      })
      .then((response) => response.json())
      .then((json) => {
        console.log(json);
        this.setState({ playerData: json, hasData: true });
      })
      .catch((responseStatus) => {
        console.log(responseStatus);
      });
  }
  render() {
    return (
      <div>
        <Container>
          <Form>
            <Form.Row>
              <Col xs={2}>
                <Form.Label htmlFor="inputSeason" style={{ color: "#e6bb44" }}>
                  Season
                </Form.Label>
              </Col>
              <Col xs={3}>
                <Form.Control
                  ref={this.year}
                  size="sm"
                  id="inputPlayerName"
                  aria-describedby="inputHelpBlock"
                />
              </Col>
              <Col xs={3}>
                <Form.Text id="inputHelpBlock" style={{ color: "#e6bb44" }}>
                  Season year such as 2010 for 2010-2011
                </Form.Text>
              </Col>
              <Col xs={8}></Col>
            </Form.Row>
          </Form>
        </Container>
        <Button onClick={this.getPlayer} variant="dark" style={{ margin: 10 }}>
          Get Best Scorers Data
        </Button>
        <BestScorersData
          myData={this.state.playerData}
          displayTable={this.state.hasData}
        ></BestScorersData>
      </div>
    );
  }
}

export default GetBestScorersData;
