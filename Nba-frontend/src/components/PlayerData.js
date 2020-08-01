import React, { Component } from "react";
import Table from "react-bootstrap/Table";
import ListGroup from "react-bootstrap/ListGroup";
import { Container } from "react-bootstrap";
class PlayerData extends Component {
  constructor(props) {
    super(props);
  }

  isEmpty(obj) {
    //check if an object is empty
    for (var key in obj) {
      if (obj.hasOwnProperty(key)) return false;
    }
    return true;
  }
  trimJson() {
    var i;
    var mylength = Object.keys(this.props.myData).length;
    for (i = 0; i < mylength; i++) {
      delete this.props.myData[i].PlayerName;
      delete this.props.myData[i].Height;
      delete this.props.myData[i].Weight;
      delete this.props.myData[i].College;
      delete this.props.myData[i].YearBorn;
      delete this.props.myData[i].BirthCity;
      delete this.props.myData[i].BirthState;
    }
  }

  render() {
    return (
      <div>
        <Container>
          {this.props.displayTable ? (
            <div>
              {!this.isEmpty(this.props.myData) ? (
                <div>
                  <ListGroup horizontal style={{ margin: 50 }}>
                    <ListGroup.Item
                      style={{ backgroundColor: "#e6bb44", color: "#211d2e" }}
                    >
                      PlayerName: {this.props.myData[0].PlayerName}
                    </ListGroup.Item>
                    <ListGroup.Item
                      style={{ backgroundColor: "#e6bb44", color: "#211d2e" }}
                    >
                      Height: {this.props.myData[0].Height}
                    </ListGroup.Item>
                    <ListGroup.Item
                      style={{ backgroundColor: "#e6bb44", color: "#211d2e" }}
                    >
                      Weight: {this.props.myData[0].Weight}
                    </ListGroup.Item>
                    <ListGroup.Item
                      style={{ backgroundColor: "#e6bb44", color: "#211d2e" }}
                    >
                      College: {this.props.myData[0].College}
                    </ListGroup.Item>
                    <ListGroup.Item
                      style={{ backgroundColor: "#e6bb44", color: "#211d2e" }}
                    >
                      YearBorn: {this.props.myData[0].YearBorn}
                    </ListGroup.Item>
                    <ListGroup.Item
                      style={{ backgroundColor: "#e6bb44", color: "#211d2e" }}
                    >
                      BirthCity: {this.props.myData[0].BirthCity}
                    </ListGroup.Item>
                    <ListGroup.Item
                      style={{ backgroundColor: "#e6bb44", color: "#211d2e" }}
                    >
                      BirthState: {this.props.myData[0].BirthState}
                    </ListGroup.Item>
                  </ListGroup>
                  <Table
                    style={{
                      overflowY: "scroll",
                      display: "block",
                      maxHeight: "400px",
                      marginLeft: "30px",
                      maxWidth: "850px",
                    }}
                    responsive
                    size="sm"
                    striped
                    bordered
                    hover
                    variant="dark"
                  >
                    {this.trimJson()}
                    {Object.keys(this.props.myData[0]).map((key, index) => {
                      //insert headers
                      return <th key={index}>{key}</th>;
                    })}
                    {this.props.myData.map((myobj, i) => {
                      return (
                        <tbody>
                          <tr>
                            {Object.keys(myobj).map((key, index) => {
                              return <td key={index}>{myobj[key]}</td>; //for each record in the json iterate through the attributes
                            })}
                          </tr>
                        </tbody>
                      );
                    })}
                  </Table>
                </div>
              ) : (
                <div style={{ marginTop: 150, marginLeft: 150 }}>
                  <h1>No Data to display for this input</h1>
                </div>
              )}
            </div>
          ) : (
            ""
          )}
        </Container>
      </div>
    );
  }
}

export default PlayerData;
