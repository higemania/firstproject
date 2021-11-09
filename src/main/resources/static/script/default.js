'use strict'

let toggleButton = null;
let menu = null;
let icons = null;
let posts_register = null;
let posts_cancel = null;
let posts_update = null;
let txt_title = null;
let txt_author = null;
let txt_content = null;
let txt_id      = null;

document.addEventListener("DOMContentLoaded", () => {

    if(!toggleButton    ){ toggleButton      = document.querySelector('.navbar__toggleBtn');}
    if(!menu            ){ menu              = document.querySelector('.navbar__menu');     }
    if(!icons           ){ icons             = document.querySelector('.navbar__icons');    }

    if(!posts_register  ){ posts_register    = document.querySelector('.posts_register');   }
    if(!posts_cancel    ){ posts_cancel      = document.querySelector('.posts_cancel');     }
    if(!posts_update    ){ posts_update      = document.querySelector('.posts_update');     }

    if(!txt_title       ){ txt_title         = document.querySelector('#txt_title');        }
    if(!txt_author      ){ txt_author        = document.querySelector('#txt_author');       }
    if(!txt_content     ){ txt_content       = document.querySelector('#txt_content');      }
    if(!txt_id          ){ txt_id            = document.querySelector('#txt_id');           }

    var reg = { //reg scope

             fnc_reg_vld : () => {
                if(!txt_title.value) {
                    alert('제목을 입력해 주십시오');
                    txt_title.setFocus();
                    return false;
                }

                if(!txt_author.value) {
                    alert('작성자를 입력해 주십시오');
                    txt_author.setFocus();
                    return false;
                }

                if(!txt_content.value) {
                     alert('내용을 입력해 주십시오');
                     txt_content.setFocus();
                    return false;
                }

                return true;
            }
    }

    toggleButton.addEventListener('click', () => {
        menu.classList.toggle('active');
        icons.classList.toggle('active');
    });

    if(posts_register){
        posts_register.addEventListener('click', () => {
            if(reg.fnc_reg_vld()){
                let param = {
                    title       : txt_title.value
                    , author    : txt_author.value
                    , content   : txt_content.value
                };

                axios.post('/api/v1/posts', param)
                .then( response =>{
//                    let strMsg = (response.status === 200) ? `정상 등록되었습니다` : `오류가 발생 하였습니다.[${response.status}]`;
//                    alert(strMsg);
                    Swal.fire({
                        icon : 'success',
                        title : '정상 등록되었습니다',
                    }).then((result) => {
                        location.replace('/');
                    });
                }).catch( reason =>{
                    alert(reason);
                    return;
                });
            }
        });
    }

    if(posts_cancel){
        posts_cancel.addEventListener('click', () => {
            alert(`cancel!!!`);
        });
    }

    if(posts_update){
        posts_update.addEventListener('click', () => {
            if(reg.fnc_reg_vld()){
                let param = {
                    id          : txt_id.value
                    , title     : txt_title.value
                    , content   : txt_content.value
                };
                axios.put(`/api/v1/posts/${txt_id.value}`, param)
                .then( response =>{
//                    let strMsg = (response.status === 200) ? `정상 등록되었습니다` : `오류가 발생 하였습니다.[${response.status}]`;
//                    alert(strMsg);
                    Swal.fire({
                        icon : 'success',
                        title : '정상 수정 되었습니다',
                    }).then((result) => {
                        location.replace('/');
                    });
                }).catch( reason =>{
                    Swal.fire({reason}).then((result) =>{
                        console.log(`>>>>>> result : ${result}`);
                        return;
                    });
                    //alert(reason);

                });
            }
        });
    }

});






