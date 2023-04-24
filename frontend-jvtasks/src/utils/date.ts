export  function converterISOToLoalDate(date :string){
const dataObjeto:Date = new Date(date);
 return dataObjeto.toLocaleDateString('pt-BR');
}

export  function getHour(date :string){
const dataObjeto: Date = new Date(date);
return dataObjeto.toLocaleTimeString('pt-BR');
}