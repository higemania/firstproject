'use strict'

posts_register.addEventListener('click', () => {
    if(fnc_validation()){
        axios.post('/api/v1/posts', {
            title : txt_title.value
            , author : txt_author.value
            , content : txt_content.value
        }).then( response =>{
            let strMsg = (response.status === 200) ? `정상 등록되었습니다` : `오류가 발생 하였습니다.[${response.status}]`;
            alert(strMsg);
        }).catch( reason =>{
            alert(reason);
        });
    }
});

posts_cancel.addEventListener('click', () => {
    alert(`cancel!!!`);
});

let fnc_validation = () => {
    if(!txt_title.value) { return false;}
    if(!txt_author.value) { return false;}
    if(!txt_content.value) { return false;}

    return true;
}