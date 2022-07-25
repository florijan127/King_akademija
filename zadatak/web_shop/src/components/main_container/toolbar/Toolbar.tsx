import React from "react";
import { Filter } from "../MainContainerData";
import FilterBar from "./filter/FilterBar";

interface Props {
    filterItems: (filter: Filter) => void;

}

const Toolbar: React.FunctionComponent<Props> = props=> {

    return (
        //open bookmarks
        <FilterBar filterItems={props.filterItems}/>

        //search form
    )
}

export default Toolbar;