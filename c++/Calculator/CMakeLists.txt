cmake_minimum_required(VERSION 3.8)
project(Calculator)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES main.cpp Calculator.cpp Calculator.h Writer.cpp Writer.h SymbolRectangle.cpp SymbolRectangle.h)
add_executable(Calculator ${SOURCE_FILES})