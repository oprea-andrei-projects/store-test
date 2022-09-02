import React, { useEffect, useState } from "react";
import Product from "./Product";
import Api from "../Api";

export default function Home(){


    let [products, setProducts] = useState([]);

    let [id, setId] = useState('');

    let fetchProducts = async ()=>{

        let api = new Api();

        let x = await api.getAllTheProducts();

        setProducts(x);
        

    }

    useEffect(()=>{

        fetchProducts();


    },[])

    let handleChanges = (e)=>{


            let obj = e.target;

            if(obj.classList.contains('prodCheck')){

                let myCode = obj.nextElementSibling.textContent;

                // console.log(myCode);

                setId(myCode);
            }

    }

    let handleDelete = ()=>{


        console.log(id);
    }


        return(
        
        
        <div className="container" onChange={handleChanges}>

            <header className="title">
                <h3>Product List</h3>
                
                
                <button className="add">Add</button>
                <button className="delete" onClick={handleDelete}>Delete</button>
                
            </header>
            <main className="cardsArea">

                {

                    products.length == 0
                    ?
                    (
                        <p>Loading...</p>
                    )
                    :
                    (
                        products.map(e=>{

                            return <Product product={e} />
                        })
                    )

                }




            </main>



            <footer className="contact">

                <p className="testText">Test Asignment</p>

            </footer>

        </div>



)




}