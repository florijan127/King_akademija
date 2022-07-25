import React from "react";
import { Filter } from "../../MainContainerData";
import style from './Filter.module.css';

interface Props {

    filterItems: (filter: Filter) => void;

}


const FilterBar: React.FunctionComponent<Props> = props=> {

    const prodNameChange = (e: React.FormEvent<HTMLInputElement>) => {
        console.log("change");
        setProdNameState((e.target as HTMLInputElement).value);
        console.log(prodNameState);
    }
    const brandNameChange = (e: React.FormEvent<HTMLInputElement>) => {
        setBrandNameState((e.target as HTMLInputElement).value)
    }
    const priceMaxChange = (e: React.FormEvent<HTMLInputElement>) => {
        setPriceMaxState((e.target as HTMLInputElement).valueAsNumber)
    }

    const [prodNameState, setProdNameState] = React.useState<string>('');
    const [brandNameState, setBrandNameState] = React.useState<string>('');
    const [priceMaxState, setPriceMaxState] = React.useState<number>(0);

    const onClickSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        props.filterItems({
            prodName: prodNameState,
            priceMax: priceMaxState,
            brandName: brandNameState
        })
    }

    const clearInputs = () => {
        setBrandNameState("");
        setProdNameState("");
        setPriceMaxState(0);

    }

    return (
        <div className={style.filter_container}>
            <form className={style.filter_form} onSubmit={onClickSubmit}>
                <label>Nazivu proizvoda:</label> <input type="text" onChange={prodNameChange} id="prodName"/>
                <label>Proizvođaču: </label><input type="text" onChange={brandNameChange} id="brandName"/>
                <label>Maksimalnoj cijeni: </label> <input type="number" step="0.01" min="0" onChange={priceMaxChange} id="priceMax"/>
                <button type="submit" className={style.filter_button} >Primijeni</button>
                {/* <input value="Obriši" type ="reset" className={style.filter_button} disabled={!(prodNameState || brandNameState || priceMaxState)}/> */}
            </form>
        </div>
    )
}

export default FilterBar;