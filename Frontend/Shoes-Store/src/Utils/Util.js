import React from 'react';

function convertAndRemoveSpaces(text) {
   const unidecoded = text.normalize('NFD').replace(/[\u0300-\u036f]/g, ''); // Chuyển đổi sang Unicode và loại bỏ dấu
   const withoutSpaces = unidecoded.replace(/\s/g, ''); // Loại bỏ dấu cách
   const lowercase = withoutSpaces.toLowerCase(); // Chuyển về chữ thường
  return lowercase;
 }

export default convertAndRemoveSpaces