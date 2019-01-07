
# This script generated MPC files from the script calls below.
# To add dependencies, add flags and arguments to the calls.
# The available flags can be seen by typing "sna_generate_mpc.py --help"
# without the quotes at the command line.

sna_generate_mpc.py \
   --base VSIPL \
   --base SignalProcessing_asm \
   --all_sources    \
   SNA_Examples_SPOC_comp.idl


if [ $? -ne 0 ]; then
   exit 1
fi

