import React, { useState } from "react";


export default function Add(){


    let[item, setItem] = useState('');

    let[sku, setSku] = useState('');
    let[name, setName] = useState('');
    let[price, setPrice] = useState('');

    let[size, setSize] = useState(0);
    let[weight, setWeight] = useState(0);
    let[height, setHeight] = useState(0);
    let[width, setWidth] = useState(0);
    let[length, setLength] = useState(0);



    let handleSelection = (e)=>{

        let obj = e.target;

        setItem(obj.value);

        console.log(item);


    }

    

    let handleChange = ()=>{
        
    }



    return(

        <div className="container2" onChange={handleChange}>

            <header className="title2">
                <h3>Product Add</h3>
                
                
                <button className="save" >Save</button>
                <button className="cancel" >Cancel</button>
                
            </header>
            <main className="formsArea">

              <label for="sku">SKU: </label>
              <input type='text' id="sku" className="sku" />

              <label for="name">Name: </label>
              <input type='text' id="name" className="name" />

              <label for="price">Price: </label>
              <input type='text' id="price" className="price" />


                <select id="selItem" className="div1"  onChange={handleSelection}> 

                        <option placeholder="type">Type Switcher</option>       
                        <option value='1' >1</option>
                        <option value='2' >2</option>
                        <option value='3' >3</option>

                </select>   

                <div className="optionsContainer" >

                    {
                        item=="Type Switcher"
                        ?
                        (
                            <p >Please select product type...</p>
                        )
                        :
                        (

                            item==1
                            ?
                            (
                                <>
                                 <label for="size">Size(MB): </label>
                                 <input type='text' id="size" className="size" />
                                
                                </>
                               
                            )
                            :
                            (
                                item==2
                                ?
                                (
                                    <>
                                        <label for="weight">Weight(KG): </label>
                                        <input type='text' id="weight" className="weight" />
                                
                                    </>
    
                                )
                                :
                                (
                                    <>
                                        <label for="length">Length(CM): </label>
                                        <input type='text' id="length" className="length" />
                                        <label for="width">Width(CM): </label>
                                        <input type='text' id="width" className="width" />
                                        <label for="height">Height(KG): </label>
                                        <input type='text' id="height" className="height" />
                                
                                    </>
    
    
                                )
    
                            )

                        )

                       
                    }

                    
                </div>   


            </main>



            <footer className="contact2">

                <p className="testText">Test Asignment</p>

            </footer>

        </div>

    )
}