import React from "react";
import { Item } from "../../MainContainerData";
import style from './Product.module.css'

interface Props {
    item: Item
    addToCart: (item:Item) => void
    removeFromCart: (item:Item) => void

}

const Product: React.FunctionComponent<Props> = props=> {

    const addToCart = () => {
        props.addToCart(props.item);
    }
    const removeFromCart = () => {
        props.removeFromCart(props.item);
    }


    return (
        <div className={style.item_container}>
            <h4>{props.item.name}</h4>
            <h5>{props.item.brand.name}</h5>
            <h6>{props.item.description}</h6>
            <h5>{props.item.price} Kn</h5>
            <h5>{props.item.inStock}</h5>
            <button onClick={addToCart}>+</button>
            <button onClick={removeFromCart} >-</button>
            
        </div>
    )
}

export default Product;