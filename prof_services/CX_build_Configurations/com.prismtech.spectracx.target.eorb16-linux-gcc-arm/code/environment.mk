ifeq ($(EORBHOME),)
   $(error EORBHOME Not Set)
endif

ifeq ($(LOCAL_OS),linux)
   export LD_LIBRARY_PATH:=$(EORBHOME)/lib/linux-gcc-x86:$(LD_LIBRARY_PATH)
else
   $(error Unsupported Host OS)
endif
