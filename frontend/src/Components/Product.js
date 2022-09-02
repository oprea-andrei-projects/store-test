import React, { useState,Link } from "react"
import Card from 'react-bootstrap/Card';

export default function Product({product}) {


    let [checked, setChecked] = useState('false');

    let handleChange = ()=>{


        if(checked=='false'){

            setChecked('true');
           
        }else{

            setChecked('false');
        }

        


        
    }


    return(<>

        <Card className="box" style={{ width: '10rem' ,height:'13rem'}}>
          <Card.Header>
            <input type="checkbox" id="prodCheck" className="prodCheck" onChange={handleChange} defaultChecked={false} />
            <p className="prodId" style={{display:'none'}}>{product.id}</p>
          </Card.Header>
          <Card.Body>

            <p className="myValue">{checked}</p>
            <p className="prodTitle">{product.name}</p>
            <p className="prodTitle">SKU: {product.sku}</p>
            <p className="price">Price: {product.price}</p>
            <Card.Text>

                {
                    product.sku.charAt(0)==1
                    ?
                    (
                     <p className="size">Size: {product.size}</p> 
                    )
                    :
                    (
                        product.sku.charAt(0)==2 
                        ? 
                        (
                            <p className="weight">Weight: {product.weight}</p>
                        )
                        :
                        (
                            <p className="dimensions">Dimension:{product.length}X{product.width}X{product.height}</p>
                        )

                    )
                }
               
            </Card.Text>
          </Card.Body>
        </Card>
        
        
        
        
        </>


    )

}