


export default class Api{


    api(path, method='GET',body=null){

        const url = "http://localhost:8080/" + path;

        const options = {

                method,
                
                headers:{

                    'Content-Type':'application/json; charset=utf-8',
                    'X-Requested-With': 'XMLHttpRequest'


                },

        };

        if(body!==null){
            options.body = JSON.stringify(body);
        }
      

        return fetch(url, options);

    }


    async getAllTheProducts(){

        let data = await this.api(`api/v1/allProducts`,`GET`);

        let data2 = await data.json();

        console.log(data2);

        return data2; 

    }

    async addtheProduct(id, product){

        let data = await this.api(`api/v1/addProduct?id=${id}`,`POST`,product); 

        let data2 = await data.json();

        console.log(data2);

        return data2;

    }


}