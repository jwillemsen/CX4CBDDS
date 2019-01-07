
# This script generated MPC files from the script calls below.
# To add dependencies, add flags and arguments to the calls.
# The available flags can be seen by typing "sna_generate_mpc.py --help"
# without the quotes at the command line.

sna_generate_mpc.py \
   --all_sources    \
   --base sna_time_management \
   --base sna_config_parameters \
   SNA_Examples_PubSubClientServer_comp.idl


if [ $? -ne 0 ]; then
   exit 1
fi

