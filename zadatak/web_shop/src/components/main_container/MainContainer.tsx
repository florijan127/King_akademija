import React from "react";
import { Cart, Filter, Item } from "./MainContainerData";
import Toolbar from "./toolbar/Toolbar";
import axios from 'axios';
import Products from "./products/Products";

const GET_FILTERED_ITEMS = 'http://192.168.5.10:8080/api/items/filter';
const GET_ALL_ITEMS = 'http://192.168.5.10:8080/api/items';

interface Props {

}



const MainContainer: React.FunctionComponent<Props> = props=> {

    const[cart, setCart] = React.useState<Cart>({items:[]});

    const [items, setItems] = React.useState<Item[]>([{
        id: 1,
        name: "proba",
        description: "",
        price: 1,
        inStock: 2,
        brand: {
            id: 1,
            name: "brand"
        }
    }])

    const [filterState, setFilter] = React.useState<Filter>({
        prodName: '',
        brandName: '',
        priceMax: 0
    })

    const getAllItems = async () => {
        try {
            const fetchedItems: Item[] = (await axios(GET_ALL_ITEMS)).data;
            console.log(fetchedItems);
            setItems(fetchedItems);


    } catch (e) {
        console.log(e);
        
    }

    }

    const fetchData = React.useCallback(async () => {

        try {
                const fetchedItems: Item[] = (await axios({
                    method: 'post',
                    url: GET_FILTERED_ITEMS,
                    data: filterState
                })).data;

                console.log(items);
                setItems(fetchedItems);

        } catch (e) {
            console.log(e);
            
        }


    }, [filterState]);

    React.useEffect(() => {
        fetchData();
    }, [fetchData]);

    const filterItems = (filter:Filter) => {
        setFilter(filter);
        console.log(filterState);
    }


    
    const addToCart = (item:Item) => {
        setCart((cart) => {return {items:[...cart.items, item]} as Cart});
        console.log(cart);

    }

    const removeFromCart = (item:Item) => {
        console.log(item);
        let found:number = 0;
        setCart((cart) => {
            let itemsReturn:Item[] = [];
            cart.items.forEach((i)=>{
                if(found == 0) {
                    if(i.id == item.id) {
                        found = 1;
                        console.log("found");
                    } else itemsReturn = [...itemsReturn, i]; 
                } else itemsReturn = [...itemsReturn, i];
                //console.log(itemsReturn);
            })
            return {items:itemsReturn} as Cart;
        } )
        console.log(cart);
    }

    return (
        <>
        <Toolbar filterItems={filterItems}/>
        {/* <Cart/> */}
        <Products items={items} addToCart={addToCart} removeFromCart={removeFromCart}/>
        </>
    )
}

export default MainContainer;