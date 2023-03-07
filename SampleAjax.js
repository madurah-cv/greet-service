import { AjaxModuleSchema } from 'journey-app';


export const AjaxModule: AjaxModuleSchema = {

   post: {

       getUserName: (param:GetParams, config:ServiceConfig) => {

           setSubPath(config);

           return getUserName(param, config)

       }

   }

 }


 function getUserName(name, config) {
    const url = "https://6477-112-135-201-140.ap.ngrok.io/greeting";
    const payload = JSON.stringify({ name: name });
  
    return fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: payload
    })
      .then(response => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then(data => {
        return data;
      })
      .catch(error => {
        console.error("There was a problem with the fetch operation:", error);
      });
  }
  