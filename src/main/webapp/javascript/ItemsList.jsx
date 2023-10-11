import React, { Component } from "react";

class ItemsList extends Component {
    render() {
        if (!this.props.items) {
            return <div>No Items in shop...</div>
        }
        return (
            <ul id="item-list">
                {this.props.items.map(item => (
                    <li key = {item.id.toString()}>
                        {item.itemName}
                        {item.price}
                        {item.stock}
                    </li>
                ))}
            </ul>
        );
    }
}

export default ItemsList;