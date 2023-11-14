"use client";
import React from 'react';
import axios from "axios"; 

const baseURL = "http://localhost:8381/v1/ecom/supplier";
function OrderForm() {
    const [post, setPost] = React.useState(null);
    React.useEffect(() => {
        axios.get(baseURL, {
            headers: {
                'Access-Control-Allow-Origin': '*'
            }
        }).then((response) => {
            setPost([response.data]);
            console.log("Response :", [response.data]);
        });
    }, []);

    if (!post) return null;

    return (
        <form>
            <label> 
                {post[0].map(supplier =>
                    <li key={supplier.supplier_name}>
                        <p>{supplier.supplier_address}</p>
                        <span>{supplier.supplier_city}</span>
                    </li>
                )}
            </label>
        </form>
    )
}

export default OrderForm;