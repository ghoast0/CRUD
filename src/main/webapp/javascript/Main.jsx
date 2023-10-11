import React, { Component } from "react";
import ReactDOM from 'react-dom';
import ItemsList from './ItemsList';
import '../css/Main.css';

class Main extends Component {
    constructor(props) {
        super(props)
        this.state = {
            items: []
        }
    }

    componentDidMount() {
        this.fetchItems();
    }

    fetchItems(){
        fetch("/getAllItems")
            .then(res => res.json())
            .then(
                (response) => {
                    this.setState({
                        items: response
                    });
                },
                (error) => {
                    alert(error);
                }
            )
    }

    handleSubmit(evt) {
        evt.preventDefault();
        fetch("/addNewItem", {
            method: "POST",
            body: new FormData(evt.target)
        }).then((response) => {
                if (response.ok) {
                    this.fetchItems();
                } else {
                    alert("Failed to add an item");
                }
            }
        ).catch((error) => {
            // Network errors
            alert(error);
        });
        evt.target.reset();
        return false;
    }

    render() {
        return (
            <div id = "main">
                <h1>Hello there</h1>
                <ItemsList items={this.state.items}/>
                <form onSubmit={this.handleSubmit.bind(this)}>
                    <input id="itemName" name="itemName" type="text" placeholder="Enter name"/>
                    <input id="price" name="price" type="number" step = "0.01" placeholder="Enter price"/>
                    <input id="stock" name="stock" type="number" placeholder="Enter stock"/>
                    <button type='submit'>Create</button>
                </form>
            </div>
        );
    }
}

ReactDOM.render(
    <Main />,
    document.getElementById('react-mountpoint')
);