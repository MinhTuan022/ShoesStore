import React, { useState } from 'react';
// import loginCustomer from '../service/LoginService';
// import {use} from 'react-router-dom'

const Login = () => {
  const [showPopup, setShowPopup] = useState(false);
  const [cusUser, setUsername] = useState('');
  const [cusPass, setPassword] = useState('');
// let use = useNavigate();
  const handleLoginClick = () => {
    setShowPopup(true);
  };

  const handlePopupClose = () => {
    setShowPopup(false);
  };

  const handleUsernameChange = (e) => {
    setUsername(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleLoginSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await loginCustomer(cusUser, cusPass)
      // const data = await response.text();
      // Xử lý phản hồi từ backend
      console.log(response.data); // Log phản hồi từ backend
      // Sau khi đăng nhập thành công, có thể thực hiện các hành động cần thiết như chuyển hướng trang, lưu token...
      // Đồng thời đóng pop-up
      setShowPopup(false);
    } catch (error) {
      console.error('Error:', error);
    }
  };

  return (
    <div>
      <button onClick={handleLoginClick}>Đăng nhập</button>
      {showPopup && (
        <div className="popup">
          <div className="popup-content">
            <span className="close" onClick={handlePopupClose}> 
              &times;
            </span>
            <form onSubmit={handleLoginSubmit}>
              <input
                type="text"
                placeholder="Tên đăng nhập"
                value={cusUser}
                onChange={handleUsernameChange}
              />
              <input
                type="password"
                placeholder="Mật khẩu"
                value={cusPass}
                onChange={handlePasswordChange}
              />
              <button type="submit">Đăng nhập</button>
            </form>
          </div>
        </div>
      )}
    </div>
  );
};

export default Login;
