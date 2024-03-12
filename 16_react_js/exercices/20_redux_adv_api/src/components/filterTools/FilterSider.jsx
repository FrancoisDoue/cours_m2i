import React, { useEffect } from "react";
import SearchTool from "./SearchTool";
import {useDispatch, useSelector} from 'react-redux'
import { initializeFilters } from "../../services/filterSevices";

const FilterSider = () => {
    const filters = useSelector(state => state.filter)
    const {isLoading} = useSelector(state => state.card)
    const dispatch = useDispatch()
    useEffect(() => {
        // if(!filters.isLoading && !isLoading){
            dispatch(initializeFilters())
        // }
    }, [])

    useEffect(() => {
        console.log('filters: ',filters)
    }, [filters])
    
    return (
        <div className="col-3 d-flex flex-column align-items-center card bg-dark border-light p-2">
            <SearchTool />
        </div>
    );
};

export default FilterSider;
