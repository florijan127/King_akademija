import React from "react";
import { Item } from "../MainContainerData";
import style from './Products.module.css';
import Product from "./product/Product";

interface Props {
    items: Item[]
    addToCart: (item:Item) => void
    removeFromCart: (item:Item) => void
}

const Products: React.FunctionComponent<Props> = props=> {

    return (
        <div className={style.items_container}>
            {
                props.items?.map((item) => {
                    return <Product item={item} addToCart={props.addToCart} removeFromCart={props.removeFromCart}/>
                })
            }
        </div>
    )
}

export default Products;