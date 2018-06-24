cmake_minimum_required(VERSION 3.8)
project(Writer)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES main.cpp Writer.h Writer.cpp Writer.h SymbolRectangle.cpp SymbolRectangle.h)
add_executable(Writer ${SOURCE_FILES})