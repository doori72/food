<template>

    <v-card outlined>
        <v-card-title>
            ConfirmDelivered
        </v-card-title>

        <v-card-text>
            <Boolean label="Confirm" v-model="value.confirm" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="confirmDelivered"
            >
                ConfirmDelivered
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'ConfirmDeliveredCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.confirm = false;
        },
        watch: {
        },
        methods: {
            confirmDelivered() {
                this.$emit('confirmDelivered', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

