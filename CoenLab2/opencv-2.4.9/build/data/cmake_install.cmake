# Install script for directory: /Applications/eclipse/opencv-2.4.9/data

# Set the install prefix
if(NOT DEFINED CMAKE_INSTALL_PREFIX)
  set(CMAKE_INSTALL_PREFIX "/usr/local")
endif()
string(REGEX REPLACE "/$" "" CMAKE_INSTALL_PREFIX "${CMAKE_INSTALL_PREFIX}")

# Set the install configuration name.
if(NOT DEFINED CMAKE_INSTALL_CONFIG_NAME)
  if(BUILD_TYPE)
    string(REGEX REPLACE "^[^A-Za-z0-9_]+" ""
           CMAKE_INSTALL_CONFIG_NAME "${BUILD_TYPE}")
  else()
    set(CMAKE_INSTALL_CONFIG_NAME "Release")
  endif()
  message(STATUS "Install configuration: \"${CMAKE_INSTALL_CONFIG_NAME}\"")
endif()

# Set the component getting installed.
if(NOT CMAKE_INSTALL_COMPONENT)
  if(COMPONENT)
    message(STATUS "Install component: \"${COMPONENT}\"")
    set(CMAKE_INSTALL_COMPONENT "${COMPONENT}")
  else()
    set(CMAKE_INSTALL_COMPONENT)
  endif()
endif()

if(NOT CMAKE_INSTALL_COMPONENT OR "${CMAKE_INSTALL_COMPONENT}" STREQUAL "libs")
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/share/OpenCV/haarcascades" TYPE FILE FILES
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_eye.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_eye_tree_eyeglasses.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_frontalface_alt.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_frontalface_alt2.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_frontalface_alt_tree.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_frontalface_default.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_fullbody.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_lefteye_2splits.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_lowerbody.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_mcs_eyepair_big.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_mcs_eyepair_small.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_mcs_leftear.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_mcs_lefteye.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_mcs_mouth.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_mcs_nose.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_mcs_rightear.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_mcs_righteye.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_mcs_upperbody.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_profileface.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_righteye_2splits.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_smile.xml"
    "/Applications/eclipse/opencv-2.4.9/data/haarcascades/haarcascade_upperbody.xml"
    )
endif()

if(NOT CMAKE_INSTALL_COMPONENT OR "${CMAKE_INSTALL_COMPONENT}" STREQUAL "libs")
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/share/OpenCV/lbpcascades" TYPE FILE FILES
    "/Applications/eclipse/opencv-2.4.9/data/lbpcascades/lbpcascade_frontalface.xml"
    "/Applications/eclipse/opencv-2.4.9/data/lbpcascades/lbpcascade_profileface.xml"
    "/Applications/eclipse/opencv-2.4.9/data/lbpcascades/lbpcascade_silverware.xml"
    )
endif()

