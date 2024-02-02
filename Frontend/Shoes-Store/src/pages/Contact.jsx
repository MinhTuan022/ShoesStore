import React from 'react'
import HeaderComponent from '../components/HeaderComponent'
import BreadCrumbComponent from '../components/BreadCrumbComponent'
import FooterComponent from '../components/FooterComponent'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faAddressBook, faAddressCard, faClock, faLocation, faLocationPin, faLocationPinLock, faMailBulk, faMailForward, faMailReply, faPhone } from '@fortawesome/free-solid-svg-icons'
import { faMailchimp } from '@fortawesome/free-brands-svg-icons'

const Contact = () => {
  return (
   
   <>
   <HeaderComponent/>
   <BreadCrumbComponent/>
   <section class="contact spad">
           <div class="container">
              <div class="row">
                 <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                    <div class="contact__widget">
                       {/* <span class="icon_phone"></span> */}
                       <FontAwesomeIcon icon={faPhone} color='#cc9966' size='2xl'/>
                       <h4>Phone</h4>
                       <p>+01-3-8888-6868</p>
                    </div>
                 </div>
                 <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                    <div class="contact__widget">
                       
                       <FontAwesomeIcon icon={faLocationPin} color='#cc9966' size='2xl'/>
                       <h4>Address</h4>
                       <p>Đại Học Xây Dựng Hà Nội</p>
                    </div>
                 </div>
                 <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                    <div class="contact__widget">
                   
                       <FontAwesomeIcon icon={faClock} color='#cc9966' size='2xl'/>
                       <h4>Open time</h4>
                       <p>10:00 am to 23:00 pm</p>
                    </div>
                 </div>
                 <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                    <div class="contact__widget">
                       
                       <FontAwesomeIcon icon={faMailBulk} color='#cc9966' size='2xl'/>
                       <h4>Email</h4>
                       <p>shoesstore@scorpio.com</p>
                    </div>
                 </div>
              </div>
           </div>
        </section><div class="map">
           <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.733594619126!2d105.84074577498005!3d21.00331348063971!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ac773026b415%3A0x499b8b613889f78a!2zVHLGsOG7nW5nIMSQ4bqhaSBI4buNYyBYw6J5IEThu7FuZyBIw6AgTuG7mWkgLSBIVUNF!5e0!3m2!1svi!2s!4v1688400185511!5m2!1svi!2s" width="600" height="450"  allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
           <div class="map-inside">
              <i class="icon_pin"></i>
              <div class="inside-widget">
                 <h4>Shoes Store</h4>
                 <ul>
                    <li>Phone: +12-345-6789</li>
                    <li>Add: Đại Học Xây Dựng Hà Nội</li>
                 </ul>
              </div>
           </div>
        </div><div class="contact-form spad">
           <div class="container">
              <div class="row">
                 <div class="col-lg-12">
                    <div class="contact__form__title">
                       <h2>Shoes Store</h2>
                    </div>
                 </div>
              </div>

           </div>
        </div>
        <FooterComponent/>
        </>
  )
}

export default Contact