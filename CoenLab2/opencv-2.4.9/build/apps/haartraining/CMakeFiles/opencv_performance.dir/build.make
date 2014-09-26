# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.0

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list

# Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/local/Cellar/cmake/3.0.2/bin/cmake

# The command to remove a file.
RM = /usr/local/Cellar/cmake/3.0.2/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Applications/eclipse/opencv-2.4.9

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Applications/eclipse/opencv-2.4.9/build

# Include any dependencies generated for this target.
include apps/haartraining/CMakeFiles/opencv_performance.dir/depend.make

# Include the progress variables for this target.
include apps/haartraining/CMakeFiles/opencv_performance.dir/progress.make

# Include the compile flags for this target's objects.
include apps/haartraining/CMakeFiles/opencv_performance.dir/flags.make

apps/haartraining/CMakeFiles/opencv_performance.dir/performance.cpp.o: apps/haartraining/CMakeFiles/opencv_performance.dir/flags.make
apps/haartraining/CMakeFiles/opencv_performance.dir/performance.cpp.o: ../apps/haartraining/performance.cpp
	$(CMAKE_COMMAND) -E cmake_progress_report /Applications/eclipse/opencv-2.4.9/build/CMakeFiles $(CMAKE_PROGRESS_1)
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Building CXX object apps/haartraining/CMakeFiles/opencv_performance.dir/performance.cpp.o"
	cd /Applications/eclipse/opencv-2.4.9/build/apps/haartraining && /usr/bin/g++   $(CXX_DEFINES) $(CXX_FLAGS) -o CMakeFiles/opencv_performance.dir/performance.cpp.o -c /Applications/eclipse/opencv-2.4.9/apps/haartraining/performance.cpp

apps/haartraining/CMakeFiles/opencv_performance.dir/performance.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/opencv_performance.dir/performance.cpp.i"
	cd /Applications/eclipse/opencv-2.4.9/build/apps/haartraining && /usr/bin/g++  $(CXX_DEFINES) $(CXX_FLAGS) -E /Applications/eclipse/opencv-2.4.9/apps/haartraining/performance.cpp > CMakeFiles/opencv_performance.dir/performance.cpp.i

apps/haartraining/CMakeFiles/opencv_performance.dir/performance.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/opencv_performance.dir/performance.cpp.s"
	cd /Applications/eclipse/opencv-2.4.9/build/apps/haartraining && /usr/bin/g++  $(CXX_DEFINES) $(CXX_FLAGS) -S /Applications/eclipse/opencv-2.4.9/apps/haartraining/performance.cpp -o CMakeFiles/opencv_performance.dir/performance.cpp.s

apps/haartraining/CMakeFiles/opencv_performance.dir/performance.cpp.o.requires:
.PHONY : apps/haartraining/CMakeFiles/opencv_performance.dir/performance.cpp.o.requires

apps/haartraining/CMakeFiles/opencv_performance.dir/performance.cpp.o.provides: apps/haartraining/CMakeFiles/opencv_performance.dir/performance.cpp.o.requires
	$(MAKE) -f apps/haartraining/CMakeFiles/opencv_performance.dir/build.make apps/haartraining/CMakeFiles/opencv_performance.dir/performance.cpp.o.provides.build
.PHONY : apps/haartraining/CMakeFiles/opencv_performance.dir/performance.cpp.o.provides

apps/haartraining/CMakeFiles/opencv_performance.dir/performance.cpp.o.provides.build: apps/haartraining/CMakeFiles/opencv_performance.dir/performance.cpp.o

# Object files for target opencv_performance
opencv_performance_OBJECTS = \
"CMakeFiles/opencv_performance.dir/performance.cpp.o"

# External object files for target opencv_performance
opencv_performance_EXTERNAL_OBJECTS =

bin/opencv_performance: apps/haartraining/CMakeFiles/opencv_performance.dir/performance.cpp.o
bin/opencv_performance: apps/haartraining/CMakeFiles/opencv_performance.dir/build.make
bin/opencv_performance: lib/libopencv_core.2.4.9.dylib
bin/opencv_performance: lib/libopencv_imgproc.2.4.9.dylib
bin/opencv_performance: lib/libopencv_highgui.2.4.9.dylib
bin/opencv_performance: lib/libopencv_objdetect.2.4.9.dylib
bin/opencv_performance: lib/libopencv_calib3d.2.4.9.dylib
bin/opencv_performance: lib/libopencv_video.2.4.9.dylib
bin/opencv_performance: lib/libopencv_features2d.2.4.9.dylib
bin/opencv_performance: lib/libopencv_flann.2.4.9.dylib
bin/opencv_performance: lib/libopencv_legacy.2.4.9.dylib
bin/opencv_performance: lib/libopencv_haartraining_engine.a
bin/opencv_performance: lib/libopencv_objdetect.2.4.9.dylib
bin/opencv_performance: lib/libopencv_legacy.2.4.9.dylib
bin/opencv_performance: lib/libopencv_calib3d.2.4.9.dylib
bin/opencv_performance: lib/libopencv_video.2.4.9.dylib
bin/opencv_performance: lib/libopencv_features2d.2.4.9.dylib
bin/opencv_performance: lib/libopencv_highgui.2.4.9.dylib
bin/opencv_performance: lib/libopencv_imgproc.2.4.9.dylib
bin/opencv_performance: lib/libopencv_flann.2.4.9.dylib
bin/opencv_performance: lib/libopencv_ml.2.4.9.dylib
bin/opencv_performance: lib/libopencv_core.2.4.9.dylib
bin/opencv_performance: apps/haartraining/CMakeFiles/opencv_performance.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --red --bold "Linking CXX executable ../../bin/opencv_performance"
	cd /Applications/eclipse/opencv-2.4.9/build/apps/haartraining && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/opencv_performance.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
apps/haartraining/CMakeFiles/opencv_performance.dir/build: bin/opencv_performance
.PHONY : apps/haartraining/CMakeFiles/opencv_performance.dir/build

apps/haartraining/CMakeFiles/opencv_performance.dir/requires: apps/haartraining/CMakeFiles/opencv_performance.dir/performance.cpp.o.requires
.PHONY : apps/haartraining/CMakeFiles/opencv_performance.dir/requires

apps/haartraining/CMakeFiles/opencv_performance.dir/clean:
	cd /Applications/eclipse/opencv-2.4.9/build/apps/haartraining && $(CMAKE_COMMAND) -P CMakeFiles/opencv_performance.dir/cmake_clean.cmake
.PHONY : apps/haartraining/CMakeFiles/opencv_performance.dir/clean

apps/haartraining/CMakeFiles/opencv_performance.dir/depend:
	cd /Applications/eclipse/opencv-2.4.9/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Applications/eclipse/opencv-2.4.9 /Applications/eclipse/opencv-2.4.9/apps/haartraining /Applications/eclipse/opencv-2.4.9/build /Applications/eclipse/opencv-2.4.9/build/apps/haartraining /Applications/eclipse/opencv-2.4.9/build/apps/haartraining/CMakeFiles/opencv_performance.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : apps/haartraining/CMakeFiles/opencv_performance.dir/depend

